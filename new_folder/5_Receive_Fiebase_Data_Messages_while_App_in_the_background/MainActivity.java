public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Title = (TextView)findViewById(R.id.text_title);
        Message = (TextView)findViewById(R.id.text_message);

        if(getIntent().getExtras()!=null)
        {
            for(String key : getIntent().getExtras().keySet())
            {
                if(key.equals("title"))
                    Title.setText(getIntent().getExtras().getString(key));
                else if(key.equals("message"))
                    Message.setText(getIntent().getExtras().getString(key));
                    
            }
        }
    }
}