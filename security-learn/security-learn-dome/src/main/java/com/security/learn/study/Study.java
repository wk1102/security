package com.security.learn.study;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *      面试题复习
 * @author issuser
 *
 */
public class Study {
	
	public static void main(String[] args) {
		//HashSet set = new HashSet();
				Set<String> sss = new HashSet<>();
				sss.add("123");
				Iterator<String>  str = sss.iterator();
				if(str.hasNext()) {
					System.err.println(str.next());
				}
				
				HashMap map = new HashMap();
				map.put("ss","123");
				System.out.println(map.put("ss",sss));
	}
}
