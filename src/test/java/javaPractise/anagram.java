package javaPractise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class anagram {

	public static void main(String[] args) {
	
		String str = "listen";
		String str3 = "silentw";
	
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		char[] ch = str.toCharArray();
		char[] ch1 = str3.toCharArray();
		
		
		for(char c:ch) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
		}
		
		for(char c1:ch1) {
			if(map.containsKey(c1)) {
				map.put(c1, map.get(c1)-1);
			}
			else {
				map.put(c1, 1);
			}
		}
		
		
		for(Map.Entry<Character, Integer> mapElement : map.entrySet()) {
			//System.out.println(mapElement.getValue());
			if(mapElement.getValue() !=0) {
				//System.out.println("is not anagram");
			}
			
		}
		Set<Character> keys = map.keySet();
		for(Character key:keys) {
			System.out.println(map.get(key));
		}
	}

}
