package stack.commons.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileParsing {
	
	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine())!= null) {
			String[] split1 = s.split("=");
			
			if (split1[0].equals("name")) {
				
				StringTokenizer tokenizer = new StringTokenizer(split1[1]);
				sb.append(tokenizer.nextToken());
				sb.append(",");
				
				sb.append(tokenizer.nextToken());
				sb.append(",");
					
				
			} else if (split1[0].equals("index")) {
				
				sb.append(split1[1] + ",");
				
			} else if (split1[0].equals("FBid")) {
				sb.append(split1[1]);
				
			} else {
				
				StringTokenizer tokenizer = new StringTokenizer(split1[1]);
				String wasted = tokenizer.nextToken();
				
				sb.append(tokenizer.nextToken() + ",");
				
			}
								
		}
		
		in.close();
		
		return sb.toString();
	}
	
	public static void writeStringToFile(String string, String  filePath) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(
						new File(filePath)
						)
				);
		
		writer.write(string);
		
		writer.newLine();
		writer.flush();
		writer.close();
		
	}
	
	public static void main(String[] args) throws Exception {
		
		String datas = read("C:\\Tests\\File1.txt");
		System.out.println(datas);
		
		writeStringToFile(datas, "C:\\Tests\\FileOuput.txt" );
		
		
	}

}