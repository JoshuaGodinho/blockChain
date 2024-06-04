import java.security.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Transactions {
    public String transactionID;
    public PublicKey sender;
    public PublicKey receiver;
    public float value;
    public byte[] signature;

    public ArrayList<TransactionInput> inputs=new ArrayList<TransactionInput>();
    public ArrayList<TransactionOutput> outputs=new ArrayList<TransactionOutput>();

    private static int sequence=0;

    public Transactions(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
        this.sender = from;
        this.receiver = to;
        this.value = value;
        this.inputs=inputs;
    }

    private String calculateHash(){
        sequence++;
        return StringUtil.applySHA256(
            StringUtil.getStringFromKey(sender)+
            StringUtil.getStringFromKey(receiver)+
            Float.toString(value)+
            sequence
        );
    }
}
