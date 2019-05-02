var exec = require('cordova/exec');

/**
 * Sends the content to the printer.
 *
 * @param [ String ]   content  The plain/html text or a file URI.
 * @param [ Object ]   options  Options for the print job.
 * @param [ Function ] success  The success callback function.
 * @param [ Function ] error    The success callback function.
 */
exports.print = function (content, success, error) {
    exec(success, error, "UsbPRINT", "print", [content || '']);
};