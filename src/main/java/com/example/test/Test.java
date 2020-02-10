package com.example.test;

import com.example.Base;

public class Test {

	public static void main(String[] args) {
//		pr("a",1,2,3,4,5,6);
		String s = "abababa33bcdabcab44cabc";
//		pr(s,"a","c");
//		String[] sArr = Base.regexExtract(s, "\\d{2}");
//		Base.pr(sArr);
//		String src = "<android.widget.ImageView index=\"0\" text=\"\" class=\"android.widget.ImageView\" package=\"com.tencent.mm\" content-desc=\"蘑菇头经典表情\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[650,1715][780,1812]\" resource-id=\"com.tencent.mm:id/eea\" instance=\"10\"/>\r\n" + 
//				"</android.widget.RelativeLayout>\r\n" + 
//				"<android.widget.RelativeLayout index=\"5\" text=\"\" class=\"android.widget.RelativeLayout\" package=\"com.tencent.mm\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"true\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[780,1715][910,1812]\" resource-id=\"\" instance=\"11\">\r\n" + 
//				"<android.widget.ImageView index=\"0\" text=\"\" class=\"android.widget.ImageView\" package=\"com.tencent.mm\" content-desc=\"兔斯基\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[780,1715][910,1812]\" resource-id=\"com.tencent.mm:id/eea\" instance=\"11\"/>";
//	
//	
//		String[] srcArr = Base.regexExtract(src, "content-desc=\"(.)+\" checkable=(\"false\")?");
//		System.out.println(srcArr.length);
//		String substring = Base.substring(srcArr[0], 14, 19);
//		System.out.println(substring);
//		Base.pr(srcArr);
	
	}
	public static void pr(String str,int ... is ) {
		for(int x=0;x<is.length;x++) {
			System.out.println(is[x]);
		}
		
	}
	public static void pr(String str,String ... regex) {
		int x = 0;
		w:  for(x = 0;x<regex.length;x++) {
			if(str.contains(regex[x])) {
				str = str.replaceAll(regex[x], regex[x]+"tttt");
				String[] sc = str.split("tttt");
				for(int y=0;y<sc.length;y++) {
					str = sc[y];
					
					continue w;
				}
			}else {
				System.out.println("'");
			}
			
		}
	}

}
