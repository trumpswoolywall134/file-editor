commandsOptions: {
    edit: {
        editors : [
            {
                // ACE Editor
                // `mimes` is not set for support everything kind of text file
                load : function(textarea) {
                    var self = this,
                        dfrd = $.Deferred(),
                        cdn  = '//cdnjs.cloudflare.com/ajax/libs/ace/1.2.5',
                        init = function() {
                            if (typeof ace === 'undefined') {
                                self.fm.loadScript([
                                    cdn+'/ace.js',
                                    cdn+'/ext-modelist.js',
                                    cdn+'/ext-settings_menu.js',
                                    cdn+'/ext-language_tools.js'
                                ], start);
                            } else {
                                start();
                            }
                        },
                        start = function() {
                            var editor, editorBase, mode,
                            ta = $(textarea),
                            taBase = ta.parent(),
                            dialog = taBase.parent(),
                            id = textarea.id + '_ace',
                            ext = self.file.name.replace(/^.+\.([^.]+)|(.+)$/, '$1$2').toLowerCase(),
                            // MIME/mode map
                            mimeMode = {
                                'text/x-php'              : 'php',
                                'application/x-php'       : 'php',
                                'text/html'               : 'html',
                                'application/xhtml+xml'   : 'html',
                                'text/javascript'         : 'javascript',
                                'application/javascript'  : 'javascript',
