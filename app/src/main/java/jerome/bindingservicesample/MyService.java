package jerome.bindingservicesample;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service
{

    public class MyBinder extends Binder
    {
        public MyService getInstance()
        {
            return MyService.this;
        }
    }
    @Override
    public void onCreate()
    {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
    @Override
    public void unbindService(ServiceConnection serviceConnection)
    {
        super.unbindService(serviceConnection);
    }

    public void testMethod()
    {

    }
}
