var Toast = function() {
};

Toast.prototype.short = function(msg, successCallback, failureCallback) {
	return PhoneGap.exec(successCallback, failureCallback, 'Toast',
			'short', [msg]);
};

Toast.prototype.long = function(msg, successCallback, failureCallback) {
	return PhoneGap.exec(successCallback, failureCallback, 'Toast',
			'long', [msg]);
};

PhoneGap.addConstructor(function() {
	PhoneGap.addPlugin("toast", new Toast());
});