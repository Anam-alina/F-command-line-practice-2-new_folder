public class FcmInstanceIdService extends FirebaseInstanceIdService {
    public void onTokenRefresh() {
        String recent_token = FirebaseInstanceId.getInstance().getToken();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(
            "com.example.prabeesh.testapp.fcm_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("com.example.prabeesh.testapp.fcm_token",recent_token);
        editor.commit();
    }


}