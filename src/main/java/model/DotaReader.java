package model;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by paulu_000 on 24/11/2015.
 */
public class DotaReader {

    public void download(String url )
    {
        download(url, Constant.FILE_NAME);
    }

public void download(String url, String fileName)
{
    try {
        URL link = new URL(url);
        InputStream in = new BufferedInputStream(link.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(response);
        fos.close();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
