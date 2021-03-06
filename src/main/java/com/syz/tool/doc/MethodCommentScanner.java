package com.syz.tool.doc;

public class MethodCommentScanner extends CommentScanner {
	public MethodCommentScanner(String resourceRoot) {
		super(resourceRoot);
	}

	@Override
	protected String handleCommentKey(String key) {
		if (key == null) {
			return "";
		}
		String str = key;
		str = str.substring(0, str.lastIndexOf("("));
		str = str.trim();
		String[] ary = str.split(" ");
		String result = ary[ary.length - 1];
		return result;
	}

	@Override
	protected String handleCommentValue(String value) {
		if (value == null) {
			return "";
		}
		String str = value;
		str = str.replaceAll("/", "");
		str = str.replaceAll("\\*", "");
		str = str.replaceAll(" ", "");
		int idx = str.indexOf("@");
		if (idx < 0) {
			idx = 0;
		}
		str = str.substring(0, idx);
		String result = str.trim();
		return result;
	}

	@Override
	protected void setValuePrefixRegex() {
		super.valuePrefixRegex = "^(/\\*+).*";
	}

	@Override
	protected void setValueSuffixRegex() {
		super.valueSuffixRegex = ".*(\\*+/\\s*)$";
	}

	@Override
	protected void setKeyRegex() {
		super.keyRegex = "(\\w+\\s+)?(\\w+\\s+)?(\\w+\\<?.*>?)\\s+\\w+\\s*\\(.*;?\\s*";
	}

}
