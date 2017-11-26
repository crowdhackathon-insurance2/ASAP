package asap;


import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class T2sserviceimpl {

    public  byte[] speak(String textToSpeak) {

        TextToSpeech client = new TextToSpeech("13a42a33-f9d1-41f7-a99d-471ea607f70d", "p7jUuiIkdrkt");
        try ( InputStream stream = client.synthesize(textToSpeak, Voice.EN_ALLISON, AudioFormat.WAV).execute();
              InputStream in = WaveUtils.reWriteWaveHeader(stream);
              OutputStream out = new FileOutputStream("hello_world.wav")){

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            return IOUtils.toByteArray(in);
        } catch (Exception e) {
            e.printStackTrace();
        }

return null;
    }

    public void speak2(String textToSpeak) {
        TextToSpeech service = new TextToSpeech();
        service.setUsernameAndPassword("{username}", "{password}");

        try {
            String text = "Hello world";
            InputStream stream = service.synthesize(text, Voice.EN_ALLISON, AudioFormat.WAV).execute();
            InputStream in = WaveUtils.reWriteWaveHeader(stream);
            OutputStream out = new FileOutputStream("hello_world.wav");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
