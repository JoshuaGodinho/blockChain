//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Main {
    public static ArrayList<Block> blockchain=new ArrayList<Block>();
    public static int difficulty =5;

    public static void main(String[] args) {

        blockchain.add(new Block("Hi Im the first block", "0"));
        System.out.println("Trying to mine block 1");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Hello Im the second block", blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to mine block 2");
        blockchain.get(1).mineBlock(difficulty);


        blockchain.add(new Block("Hey there, I am the third block", blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to mine block 3");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\n Blockchain is valid\n"+isChainValid());


        String blockChainJSON =new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("The blockchain is :");
        System.out.println(blockChainJSON);
    }

    public static boolean isChainValid() {
        Block currentblock;
        Block previousblock;
        String hashTarget= new String(new char[difficulty]).replace("\0", "0");

        for(int i=1;i<blockchain.size();i++) {
            currentblock=blockchain.get(i);
            previousblock=blockchain.get(i-1);

            if(!currentblock.hash.equals(currentblock.calculateHash())) {
                System.out.println("\nCurrent hashes not equal");
                return false;
            }

            if(!previousblock.hash.equals(currentblock.previousHash)) {
                System.out.println("\nPrevious hashes not equal");
                return false;
            }

            if(!currentblock.hash.substring(0,difficulty).equals(hashTarget)) {
                System.out.println("\nThe block hasnt been mined");
                return false;
            }
        }
        return true;
    }
}