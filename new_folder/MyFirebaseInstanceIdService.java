public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
   private static final string REG_TOKEN = "REG_TOKEN";
   public void onTokenRefresh() {
       String recent_token = FirebaseInstanceId.getInstance().getToken();
       Log.d(REG_TOKEN,recent_token);
   } 
}