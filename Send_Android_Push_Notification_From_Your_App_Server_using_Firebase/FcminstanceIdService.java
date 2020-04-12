public class FcmInstanceIdService extends FirebaseInstanceIdService {
    public void onTokenRefresh() {
        String recent_token = FirebaseInstanceId.getInstance().getToken();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(gretString(R.String.FCM_TOKEN),recent_token);
        editor.commit();
    }


}