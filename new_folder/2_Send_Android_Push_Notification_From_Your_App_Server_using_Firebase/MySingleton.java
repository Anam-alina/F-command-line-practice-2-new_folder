public class MySingleton {
    private static MySingleton mInstance;
    private static Context mCtx;
    private RequestQueue requestQueue;

    private MySingleton(Context context)
    {
        mCtx = context;
        requestQueue = getRequestQueue();
    }
    private RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized MySingleton getmInstance(Context context)
    {
        if(mInstance==null)
        {
            mInstance = new MySingleton(context);
        }
        return mInstance; 
    }
    public<T> void addToRequest(Request<T> request)
    {
        getRequestQueue().add(request);
    }
}