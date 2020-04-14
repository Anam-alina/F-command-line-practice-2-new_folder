public class MainActivity extends AppCompatActivity {
    TextView textView;
    String message = "No new Messages";

    String app_server_url = "http://10.0.2.2/fcmtest/fcm_insert.php";
    protected void onCreate(Bundlde savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
                String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN),"");
                StringRequest stringRequest = new StringRequest(Request.Method.POST,app_server_url, ) {
                       new Response.Listener<String>() {
                            public void onResponse(String response) {

                            }
                        }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {

                    }
                    }
                }
                {
                    protected Map<String, String> getParamas() throws AuthFailureError {
                        Map<String,String> paramas = new HashMap<String, String>();
                        paramas.put("fcm_token",token);
                        return paramas;
                    }
                };
                MySingleton.getmInstance(MainActivity.this).addToRequestque(stringRequest);
              textView = (TextView)findViewById(R.id.textView);
                
                if(getIntent().getExtras()!=null)
                {
                    message = getIntent().getExtras().getString("message");
                    if(message==null)
                    {
                        message = "No New Messages";
                    }
                }
            }
        });
    }
}