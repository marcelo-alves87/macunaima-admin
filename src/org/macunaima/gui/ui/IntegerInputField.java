package org.macunaima.gui.ui;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class IntegerInputField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntegerInputField() {
		super(10);
		PlainDocument doc = (PlainDocument) getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
			private boolean isValid(String testText) {
				if (testText.length() > 2) {
					return false;
				}
				if (testText.isEmpty()) {
					return true;
				}
				int intValue = 0;
				try {
					intValue = Integer.parseInt(testText.trim());
				} catch (NumberFormatException e) {
					return false;
				}
				if (intValue < 0 || intValue > 99) {
					return false;
				}
				return true;
			}

			@Override
			public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr)
					throws BadLocationException {
				StringBuilder sb = new StringBuilder();
				sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
				sb.insert(offset, text);
				if (isValid(sb.toString())) {
					super.insertString(fb, offset, text, attr);
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				StringBuilder sb = new StringBuilder();
				sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
				int end = offset + length;
				sb.replace(offset, end, text);
				if (isValid(sb.toString())) {
					super.replace(fb, offset, length, text, attrs);
				}
			}

			@Override
			public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
				StringBuilder sb = new StringBuilder();
				sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
				int end = offset + length;
				sb.delete(offset, end);
				if (isValid(sb.toString())) {
					super.remove(fb, offset, length);
				}
			}
		});
	}
}
