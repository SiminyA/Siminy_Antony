package assessment.project.truecaller.truecallerproject;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DownloadTruecaller extends AsyncTask<Object,Void,String> {
    private Context context;
    private String url;

    public DownloadTruecaller(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    @Override
    protected String doInBackground(Object... urls) {
        return geturl(url);
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ((MainActivity) (context)).onSuccess(result);
       // Log.i("json", result);
    }

    public static String geturl(String url)
    {

        String htmldata= null;
        HttpsURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            URL testurl = new URL(url);
            urlConnection = (HttpsURLConnection) testurl.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            Log.d("Siminy","Truecaller"+testurl);
            InputStream datastream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(datastream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }
            htmldata = buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return htmldata;
    }
}

