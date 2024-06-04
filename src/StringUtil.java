import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class StringUtil {
    public static String applySHA256(String input) {
        try{
            MessageDigest digest=MessageDigest.getInstance("SHA-256");
            byte[] hash=digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString=new StringBuffer();
            for(int i=0;i<hash.length;i++){
                String hex=Integer.toHexString(0xff & hash[i]);
                if(hex.length()==1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static byte[] applyECDSASignature(PrivateKey privateKey, String input){
        Signature dsa;
        byte[] ouput=new byte[0];
        try {
            dsa=Signature.getInstance("ECDSA", "BC");
            dsa.initSign(privateKey);
            byte[] str=input.getBytes();
            dsa.update(str);
            byte[] sign=dsa.sign();
            ouput=sign;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return ouput;
    }

    public static boolean verifyECDSASignature(PublicKey publicKey, String data, byte[] signature){
        try{
            Signature ecdsa=Signature.getInstance("ECDSA", "BC");
            ecdsa.initVerify(publicKey);
            ecdsa.update(data.getBytes());
            return ecdsa.verify(signature);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String getStringFromKey(Key key) {
		return Base64.getEncoder().encodeToString(key.getEncoded());
	}
}
