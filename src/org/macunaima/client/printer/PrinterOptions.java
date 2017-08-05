package org.macunaima.client.printer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//------------------------
//-- PrinterOptions.java
//------------------------

public class PrinterOptions {
	String commandSet = "";
	static Map<Character, Byte> asciiMap = null;

	public String initialize() {
		final byte[] Init = { 27, 64 };
		commandSet += new String(Init);
		return new String(Init);
	}

	private void fillAsciiMap() {
		if (asciiMap == null) {
			asciiMap = new HashMap<Character, Byte>();

			Byte byte1 = 32;
			put(new Character(' '), byte1);
			
			byte1 = 9;
			put(new Character('\t'), byte1);

			byte1 = 33;
			put(new Character('!'), byte1);

			byte1 = 34;
			put(new Character('"'), byte1);

			byte1 = 35;
			put(new Character('#'), byte1);

			byte1 = 36;
			put(new Character('$'), byte1);

			byte1 = 37;
			put(new Character('%'), byte1);

			byte1 = 38;
			put(new Character('&'), byte1);

			byte1 = 39;
			put(new Character('\''), byte1);

			byte1 = 40;
			put(new Character('('), byte1);

			byte1 = 41;
			put(new Character(')'), byte1);

			byte1 = 42;
			put(new Character('*'), byte1);

			byte1 = 43;
			put(new Character('+'), byte1);

			byte1 = 44;
			put(new Character(','), byte1);

			byte1 = 45;
			put(new Character('-'), byte1);

			byte1 = 46;
			put(new Character('.'), byte1);

			byte1 = 47;
			put(new Character('/'), byte1);

			byte1 = 48;
			put(new Character('0'), byte1);

			byte1 = 49;
			put(new Character('1'), byte1);

			byte1 = 50;
			put(new Character('2'), byte1);

			byte1 = 51;
			put(new Character('3'), byte1);

			byte1 = 52;
			put(new Character('4'), byte1);

			byte1 = 53;
			put(new Character('5'), byte1);

			byte1 = 54;
			put(new Character('6'), byte1);

			byte1 = 55;
			put(new Character('7'), byte1);

			byte1 = 56;
			put(new Character('8'), byte1);

			byte1 = 57;
			put(new Character('9'), byte1);

			byte1 = 58;
			put(new Character(':'), byte1);

			byte1 = 59;
			put(new Character(';'), byte1);

			byte1 = 60;
			put(new Character('<'), byte1);

			byte1 = 61;
			put(new Character('='), byte1);

			byte1 = 62;
			put(new Character('>'), byte1);

			byte1 = 63;
			put(new Character('?'), byte1);

			byte1 = 64;
			put(new Character('@'), byte1);

			byte1 = 65;
			put(new Character('A'), byte1);

			byte1 = 66;
			put(new Character('B'), byte1);

			byte1 = 67;
			put(new Character('C'), byte1);

			byte1 = 68;
			put(new Character('D'), byte1);

			byte1 = 69;
			put(new Character('E'), byte1);

			byte1 = 70;
			put(new Character('F'), byte1);

			byte1 = 71;
			put(new Character('G'), byte1);

			byte1 = 72;
			put(new Character('H'), byte1);

			byte1 = 73;
			put(new Character('I'), byte1);

			byte1 = 74;
			put(new Character('J'), byte1);

			byte1 = 75;
			put(new Character('K'), byte1);

			byte1 = 76;
			put(new Character('L'), byte1);

			byte1 = 77;
			put(new Character('M'), byte1);

			byte1 = 78;
			put(new Character('N'), byte1);

			byte1 = 79;
			put(new Character('O'), byte1);

			byte1 = 80;
			put(new Character('P'), byte1);

			byte1 = 81;
			put(new Character('Q'), byte1);

			byte1 = 82;
			put(new Character('R'), byte1);

			byte1 = 83;
			put(new Character('S'), byte1);

			byte1 = 84;
			put(new Character('T'), byte1);

			byte1 = 85;
			put(new Character('U'), byte1);

			byte1 = 86;
			put(new Character('V'), byte1);

			byte1 = 87;
			put(new Character('W'), byte1);

			byte1 = 88;
			put(new Character('X'), byte1);

			byte1 = 89;
			put(new Character('Y'), byte1);

			byte1 = 90;
			put(new Character('Z'), byte1);

			byte1 = 91;
			put(new Character('['), byte1);

			byte1 = 92;
			put(new Character('\\'), byte1);

			byte1 = 93;
			put(new Character(']'), byte1);

			byte1 = 94;
			put(new Character('^'), byte1);

			byte1 = 95;
			put(new Character('_'), byte1);

			byte1 = 96;
			put(new Character('`'), byte1);

			byte1 = 97;
			put(new Character('a'), byte1);

			byte1 = 98;
			put(new Character('b'), byte1);

			byte1 = 99;
			put(new Character('c'), byte1);

			byte1 = 100;
			put(new Character('d'), byte1);

			byte1 = 101;
			put(new Character('e'), byte1);

			byte1 = 102;
			put(new Character('f'), byte1);

			byte1 = 103;
			put(new Character('g'), byte1);

			byte1 = 104;
			put(new Character('h'), byte1);

			byte1 = 105;
			put(new Character('i'), byte1);

			byte1 = 106;
			put(new Character('j'), byte1);

			byte1 = 107;
			put(new Character('k'), byte1);

			byte1 = 108;
			put(new Character('l'), byte1);

			byte1 = 109;
			put(new Character('m'), byte1);

			byte1 = 110;
			put(new Character('n'), byte1);

			byte1 = 111;
			put(new Character('o'), byte1);

			byte1 = 112;
			put(new Character('p'), byte1);

			byte1 = 113;
			put(new Character('q'), byte1);

			byte1 = 114;
			put(new Character('r'), byte1);

			byte1 = 115;
			put(new Character('s'), byte1);

			byte1 = 116;
			put(new Character('t'), byte1);

			byte1 = 117;
			put(new Character('u'), byte1);

			byte1 = 118;
			put(new Character('v'), byte1);

			byte1 = 119;
			put(new Character('w'), byte1);

			byte1 = 120;
			put(new Character('x'), byte1);

			byte1 = 121;
			put(new Character('y'), byte1);

			byte1 = 122;
			put(new Character('z'), byte1);

			byte1 = 123;
			put(new Character('{'), byte1);

			byte1 = 124;
			put(new Character('|'), byte1);

			byte1 = 125;
			put(new Character('}'), byte1);

			byte1 = 126;
			put(new Character('~'), byte1);

			byte1 = -128;
			put(new Character('Ç'), byte1);

			byte1 = -126;
			put(new Character('é'), byte1);

			byte1 = -125;
			put(new Character('â'), byte1);

			byte1 = -123;
			put(new Character('à'), byte1);

			byte1 = -121;
			put(new Character('ç'), byte1);

			byte1 = -120;
			put(new Character('ê'), byte1);

			byte1 = -112;
			put(new Character('É'), byte1);

			byte1 = -109;
			put(new Character('Ô'), byte1);

			byte1 = -106;
			put(new Character('û'), byte1);

			byte1 = -96;
			put(new Character('á'), byte1);

			byte1 = -95;
			put(new Character('í'), byte1);

			byte1 = -94;
			put(new Character('ó'), byte1);

			byte1 = -93;
			put(new Character('ú'), byte1);

			byte1 = -92;
			put(new Character('ñ'), byte1);

			byte1 = -93;
			put(new Character('Ñ'), byte1);

			byte1 = -91;
			put(new Character('º'), byte1);

			byte1 = -113;
			put(new Character('Á'), byte1);
			
			byte1 = -113;
			put(new Character('Ã'), byte1);
			
			byte1 = -113;
			put(new Character('Â'), byte1);
			
			byte1 = -112;
			put(new Character('Ê'), byte1);
			
			byte1 = -95;
			put(new Character('Í'), byte1);
			
			byte1 = -103;
			put(new Character('Ó'), byte1);
			
			byte1 = -103;
			put(new Character('Ô'), byte1);
			
			byte1 = -103;
			put(new Character('Õ'), byte1);
			
			byte1 = -102;
			put(new Character('Ú'), byte1);
			
			byte1 = -102;
			put(new Character('Û'), byte1);
			
			byte1 = -107;
			put(new Character('õ'), byte1);
			
		}
	}

	private void put(Character c, Byte byte1) {
		asciiMap.put(c, byte1);
	}

	public String chooseFont(int Options) {
		String s = "";
		final byte[] ChooseFontA = { 27, 77, 0 };
		final byte[] ChooseFontB = { 27, 77, 1 };
		final byte[] ChooseFontC = { 27, 77, 48 };
		final byte[] ChooseFontD = { 27, 77, 49 };

		switch (Options) {
		case 1:
			s = new String(ChooseFontA);
			break;

		case 2:
			s = new String(ChooseFontB);
			break;

		case 3:
			s = new String(ChooseFontC);
			break;

		case 4:
			s = new String(ChooseFontD);
			break;

		default:
			s = new String(ChooseFontB);
		}
		commandSet += s;
		return new String(s);
	}

	public String feedBack(byte lines) {
		final byte[] Feed = { 27, 101, lines };
		String s = new String(Feed);
		commandSet += s;
		return s;
	}

	public String feed(byte lines) {
		final byte[] Feed = { 27, 100, lines };
		String s = new String(Feed);
		commandSet += s;
		return s;
	}

	public String alignLeft() {
		final byte[] AlignLeft = { 27, 97, 48 };
		String s = new String(AlignLeft);
		commandSet += s;
		return s;
	}

	public String alignCenter() {
		final byte[] AlignCenter = { 27, 97, 49 };
		String s = new String(AlignCenter);
		commandSet += s;
		return s;
	}

	public String alignRight() {
		final byte[] AlignRight = { 27, 97, 50 };
		String s = new String(AlignRight);
		commandSet += s;
		return s;
	}

	public String newLine() {
		final byte[] LF = { 10 };
		String s = new String(LF);
		commandSet += s;
		return s;
	}

	public String reverseColorMode(boolean enabled) {
		final byte[] ReverseModeColorOn = { 29, 66, 1 };
		final byte[] ReverseModeColorOff = { 29, 66, 0 };

		String s = "";
		if (enabled)
			s = new String(ReverseModeColorOn);
		else
			s = new String(ReverseModeColorOff);

		commandSet += s;
		return s;
	}

	public String doubleStrik(boolean enabled) {
		final byte[] DoubleStrikeModeOn = { 27, 71, 1 };
		final byte[] DoubleStrikeModeOff = { 27, 71, 0 };

		String s = "";
		if (enabled)
			s = new String(DoubleStrikeModeOn);
		else
			s = new String(DoubleStrikeModeOff);

		commandSet += s;
		return s;
	}

	public String doubleHeight(boolean enabled) {
		final byte[] DoubleHeight = { 27, 33, 17 };
		final byte[] UnDoubleHeight = { 27, 33, 0 };

		String s = "";
		if (enabled)
			s = new String(DoubleHeight);
		else
			s = new String(UnDoubleHeight);

		commandSet += s;
		return s;
	}

	public String emphasized(boolean enabled) {
		final byte[] EmphasizedOff = { 27, 0 };
		final byte[] EmphasizedOn = { 27, 1 };

		String s = "";
		if (enabled)
			s = new String(EmphasizedOn);
		else
			s = new String(EmphasizedOff);

		commandSet += s;
		return s;
	}

	public String underLine(int Options) {
		final byte[] UnderLine2Dot = { 27, 45, 50 };
		final byte[] UnderLine1Dot = { 27, 45, 49 };
		final byte[] NoUnderLine = { 27, 45, 48 };

		String s = "";
		switch (Options) {
		case 0:
			s = new String(NoUnderLine);
			break;

		case 1:
			s = new String(UnderLine1Dot);
			break;

		default:
			s = new String(UnderLine2Dot);
		}
		commandSet += s;
		return new String(s);
	}

	public String color(int Options) {
		final byte[] ColorRed = { 27, 114, 49 };
		final byte[] ColorBlack = { 27, 114, 48 };

		String s = "";
		switch (Options) {
		case 0:
			s = new String(ColorBlack);
			break;

		case 1:
			s = new String(ColorRed);
			break;

		default:
			s = new String(ColorBlack);
		}
		commandSet += s;
		return s;
	}

	public String finit() {
		final byte[] FeedAndCut = { 29, 'V', 66, 0 };

		String s = new String(FeedAndCut);

		final byte[] DrawerKick = { 27, 70, 0, 60, 120 };
		s += new String(DrawerKick);

		commandSet += s;
		return s;
	}

	public String addLineSeperator() {
		String lineSpace = "----------------------------------------";
		commandSet += lineSpace;
		return lineSpace;
	}

	public void resetAll() {
		fillAsciiMap();
		commandSet = "";
	}

	public void setText(String s) {
		toASCII(s);
	}

	public String finalCommandSet() {
		return commandSet;
	}

	private void toASCII(String string) {
		List<Byte> bytes = new ArrayList<Byte>();
		for (int i = 0; i < string.length(); i++) {
			Character character = new Character(string.charAt(i));
			if (asciiMap.get(character) != null) {
				bytes.add(asciiMap.get(character));
			} else {
				bytes.add((byte) 63);
			}
		}

		byte[] bytesString = new byte[bytes.size()];
		for (int i = 0; i < bytes.size(); i++) {
			Byte byte1 = bytes.get(i);
			bytesString[i] = byte1.byteValue();
		}

		commandSet += new String(bytesString);
	}

	/*
	 * private void toASCII(String string) { byte[] bytesString = null; try {
	 * bytesString = string.getBytes("CP858"); } catch
	 * (UnsupportedEncodingException e) { e.printStackTrace(); } commandSet+=new
	 * String(bytesString); }
	 */
}