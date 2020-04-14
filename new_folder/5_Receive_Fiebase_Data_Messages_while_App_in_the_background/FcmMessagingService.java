public class FcmMessagingService extends FirebaseMessagingService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(remoteMessage.getData().size()>0)
        {
            String title = remoteMessage.getData().get("title");
            String message = remoteMessage.getData().get("message");
            Intent intent = new Intent("com.xyz.testingapp_FCM-MESSAGE");
            intent.putExtra("title",title);
            intent.putExtra("message",message);
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
            localBroadcastManager.sendBroadcast(intent);

        }
    }
}