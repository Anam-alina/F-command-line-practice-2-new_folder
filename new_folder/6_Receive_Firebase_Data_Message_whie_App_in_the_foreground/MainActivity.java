public class MainActivity extends AppCompatActivity {
    TextView Msg_title.Msg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LocalBroadcastManager.getInstance(this).registerReceivcer(mHandler,new IntentFilter("com.xyz.testingapp_FCM-MESSAGE"));
        setContentView(R.layout.activity_main);
        Msg_title = (TextView)findViewById(R.id.msg_title);
        Msg = (TextView)findViewById(R.id.msg);
        if(getIntent().getExtras()!=null)
        {
            for(String key : getIntent().getExtras().keySet())
            {
                if(key.equals("title"))
                    Msg_title.setText(getIntent().getExtras().getString(key));
                else if(key.equals("message"))
                    Msg.setText(getIntent().getExtras().getString(key));
                    
            }
        }
    }
}

private BroadcastReceiver mHandler = new BroadcastReceiver() {
    public void onreceive(Context context,Intent intent) {
        String title = intent.getStringExtra("title");
        String message = intent.getStringExtra("message");
        Msg_title.setText(title);
        Msg.setText(message);

    }
};

    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mHandler);
    }