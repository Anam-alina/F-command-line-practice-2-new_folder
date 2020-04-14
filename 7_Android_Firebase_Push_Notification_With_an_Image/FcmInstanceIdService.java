public class FcmInstanceIdService extends FirebaseInstanceIdService {
    public void onTokenRefresh() {
        String fcm_token = FirebaseInstanceId.getInstance().getToken();
        Log.d("FCM_TOKEN",fcm_token);
    }
}