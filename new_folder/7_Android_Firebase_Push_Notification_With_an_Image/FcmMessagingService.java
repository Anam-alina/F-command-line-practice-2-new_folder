public class FcmMessagingService extends FirebaseMessagingService {
    public void onMessageReceived(RemoteMessage  remoteMessage) {
        if(remoteMessage.getData(.size()>0))
        {
            String title,message,img_url;

            title = remoteMessage.getData().get("title");
            message = remoteMessage.getData().get("message");
            img_url = remoteMessage.getData().get("img_yrl");

            Intent intent = new Intent(this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
            Uri sounduri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
            builder.setContentTitle(title);
            builder.setContentText(message);
            builder.setContentIntent(pendingIntent);
            builder.setSound(sounduri);
            builder.setSmallIcon(R.drawable.ic_notification);

            ImageRequest imageRequest = new imageRequest(img_url,new Response.Listener<Bitmap>() {
                public void onResponse(Bitmap response) {
                    buildr.setStyle(new NotificationCompat.BigPictureStyle()bigPicture(response));
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFIOCATION_SERVICE);
                  notificationManager.notify(0,builder.build());

                }
            },0,0,null,Bitmap.Config.RGB_565, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError errror) {

                }
            });

            MySingleton.getmInstanse(this.addToRequestQue(imageRequest);
            

        }
    }
}