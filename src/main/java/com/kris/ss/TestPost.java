package com.kris.ss;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestPost {
	public static void main(String[] argc) throws MalformedURLException, Exception {
		String res = post(new URL("http://localhost:8080/ss/home"), "");
		System.out.println(res);
	}
	public static String post (URL url, String postParams) throws Exception {
		int retry = 1;
		StringWriter sw =null;
		while (++retry <= TestPost.MAX_RETRY) {
			
			//OutputStream out = null;
			HttpURLConnection con = null;
			try {
				sw = new StringWriter();
				con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setUseCaches(false);
				con.setDoInput(true);
				con.setDoOutput(true);
				con.setRequestProperty("Cookie", "JSESSIONID=49C717A8F10C5A8180CA160B4F53E64D");
				con.setRequestProperty("Connection", "Keep-Alive");
				con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:12.0) Gecko/20100101 Firefox/12.0");
				//con.connect();
				OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
				wr.write(postParams);
				wr.flush();
				if (con.getResponseCode() == 200) {
					InputStream in = con.getInputStream();
					byte[] buf = new byte[32 * 1024];
					int read;
					while ((read = in.read(buf)) != -1) {
						sw.write(new String(buf, 0, read));
					}
				}
				retry = TestPost.MAX_RETRY;
			}
			catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Retry (" + retry + ") download url " + url);
			}
			finally {
				if (sw != null) {
					try {
						sw.close();
					}
					catch (Exception ex) {

					}
				}

				if (con != null) {
					try {
						con.disconnect();
					}
					catch (Exception ex) {

					}
				}
			}
		
			long delay = 200L + ((long) (Math.random() * 1800.0));
			System.out.println("Downloaded url " + url );
//			System.out.println("Waiting for " + delay + "ms...");
			Thread.sleep(delay);
			
		}
		return sw.toString();
	}
	
	public static int MAX_RETRY=3;
}
