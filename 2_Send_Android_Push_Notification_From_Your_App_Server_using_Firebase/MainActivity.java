public class MainActivity extends AppCompatActivity {
    Button button;
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

                        return super.getParamas();
                    }
                };
                MySingleton.getmInstance(MainActivity.this).addToRequestque(stringRequest);
            }
        });
    }
}