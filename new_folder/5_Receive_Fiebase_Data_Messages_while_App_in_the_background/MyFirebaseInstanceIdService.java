public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN",token);
    }
}