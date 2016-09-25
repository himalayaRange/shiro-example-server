package org.zygx.shiro.test;

import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.junit.Test;

public class AntMatcherTest {

	@Test
	public void test(){
		/**
		 * 
		 *  /admin/role/*,/admin,false
		/admin/*,/admin,false
		/admin/role/update,/admin,false
		/admin/role/add,/admin,false
		 * 	
		 */
		String a="/admin/*";
		String b="/admin/user";
		PatternMatcher patternMatcher=new AntPathMatcher();
		System.out.println(patternMatcher.matches(a,b));
		
	}
}
