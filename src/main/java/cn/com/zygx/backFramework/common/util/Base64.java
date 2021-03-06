/**  
 * @author wangyi
 * @date 2016-6-20 下午3:12:44 
 * @version V1.0   
 */ 
package cn.com.zygx.backFramework.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.mail.internet.MimeUtility;

/**
 * Base 64工具
 * @author wangyi
 * @date 2016-6-20 下午3:12:44 
 */
public class Base64 {
	public static byte[] encode(byte[] b) throws Exception {  
        ByteArrayOutputStream baos = null;  
        OutputStream b64os = null;  
        try {  
            baos = new ByteArrayOutputStream();  
            b64os = MimeUtility.encode(baos, "base64");  
            b64os.write(b);  
            b64os.close();  
            return baos.toByteArray();  
        } catch (Exception e) {  
            throw new Exception(e);  
        } finally {  
            try {  
                if (baos != null) {  
                    baos.close();  
                    baos = null;  
                }  
            } catch (Exception e) {  
            }  
            try {  
                if (b64os != null) {  
                    b64os.close();  
                    b64os = null;  
                }  
            } catch (Exception e) {  
            }  
        }  
    }  
  
    public static byte[] decode(byte[] b) throws Exception {  
        ByteArrayInputStream bais = null;  
        InputStream b64is = null;  
        try {  
            bais = new ByteArrayInputStream(b);  
            b64is = MimeUtility.decode(bais, "base64");  
            byte[] tmp = new byte[b.length];  
            int n = b64is.read(tmp);  
            byte[] res = new byte[n];  
            System.arraycopy(tmp, 0, res, 0, n);  
            return res;  
        } catch (Exception e) {  
            throw new Exception(e);  
        } finally {  
            try {  
                if (bais != null) {  
                    bais.close();  
                    bais = null;  
                }  
            } catch (Exception e) {  
            }  
            try {  
                if (b64is != null) {  
                    b64is.close();  
                    b64is = null;  
                }  
            } catch (Exception e) {  
            }  
        }  
    }  
}
