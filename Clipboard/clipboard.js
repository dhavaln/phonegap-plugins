/**
 * 
 */

var Clipboard = function() {
};

Clipboard.prototype.set = function(data, successCallback, failureCallback) {
	return PhoneGap.exec(successCallback, failureCallback, 'Clipboard',
			'set', [data]);
};

Clipboard.prototype.get = function(successCallback, failureCallback) {
	return PhoneGap.exec(successCallback, failureCallback, 'Clipboard',
			'get', []);
};

PhoneGap.addConstructor(function() {
	PhoneGap.addPlugin("clipboard", new Clipboard());
});