import java.util.ArrayList;
import java.util.List;
import org.jason.JSONObject;

public class ShamirSecretSharing {
    public static void main(String[] args){
        String jsonInput = "{\"n\":4, \"k\":3,\"1\": {\"base\": \"10\", \"value\": \"4\"}, \"2\": {\"base\": \"2\", \"value\": \"111\"}, {\"base\": \"10\", \"value\": \"12\", \"6\": {\"base\": \"4\", \"value\": \"213\"}}}";
        JSONObject jasonObject = new JSONObject(jasonInput);
        int n = jasonObject.getInt("n");
        int k = jasonObject.getInt("k");
        List<Root> roots =new ArrayList<>();

        for(int i=1;i<=n; i++){
            JSONObject rootObject = jasonObject.getJSONObject(String.valueOf(i));
            int base = Integer.parseInt(rootObject.getString("base"));
            String value = rootObjec.getString("value");
            int x= i;
            int y= convertBase(value, base);
            roots.add(new Root(x, y));
        }
        int c = findConstantTerm(k, roots);
        System.out.println("The constant term 'c' is: " + c);
            }
            static class Root{
                int x;
                int y;
                public Root(int x, int y) {
                    this.x = x;
                    ths.y = y;
                }
            }
            static int convertBase(String value, int base){
                int decimalValue =0;
                for(int i=0; i<value.length(); i++){
                    int digit = Character.getNumericValue(value.charAt(i));
                    decimalValue = decimalValue * base + digit;
                }
                return decimalValue;
            }
            static int findConstantTerm(int k, List<root> roots) {
                int c =0;
                for(Root root : roots){
                    int numerator = 1;
                    int denominator = 1;
                    fo(Root otherRoot : roots){
                        if(otherRoot != roots){
                            numerator *= otherRoot.x;
                            denominator *= otherRoot.x - root.x;
                        }
                    }
                    c += root.y * numerator / denominator;
                }
                return c;
            }
}