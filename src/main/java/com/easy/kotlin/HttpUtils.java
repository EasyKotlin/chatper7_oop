package com.easy.kotlin;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jack on 2017/7/6.
 */
public class HttpUtils {
    static OkHttpClient client = new OkHttpClient();

    public static String getSync(String url) throws IOException {
        Request request = new Request.Builder()
            .url(url)
            .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) { throw new IOException("Unexpected code " + response); }
        return response.body().string();
    }

    public void getAsync(String url) throws IOException {
        Request request = new Request.Builder()
            .url(url)
            .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) { throw new IOException("Unexpected code " + response); }
                String result = response.body().string();
            }
        });

    }
}
