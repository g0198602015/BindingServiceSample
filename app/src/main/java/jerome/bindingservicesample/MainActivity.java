package jerome.bindingservicesample;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jerome on 2016/1/8.
 */
public class MainActivity extends Activity
{
    Intent mBindServiceIntent;
    private MyService mBinderService;
    @Override
    protected void onCreate(Bundle saveInstanceBundle)
    {
        super.onCreate(saveInstanceBundle);
        setContentView(R.layout.main);
        Button mBindButton = (Button)findViewById(R.id.bindButton);
        Button mUnbindButton = (Button)findViewById(R.id.unbindButton);
        mBindButton.setOnClickListener(mClickListener);
        mUnbindButton.setOnClickListener(mClickListener);
        mBindServiceIntent = new Intent(MainActivity.this, MyService.class);
    }
    private View.OnClickListener mClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (v.getId() == R.id.bindButton)
            {

                bindService(mBindServiceIntent, mServiceConnecion, Service.BIND_AUTO_CREATE);
            }
            else if (v.getId() == R.id.unbindButton)
            {
                unbindService(mServiceConnecion);
            }

        }
    };

    private ServiceConnection mServiceConnecion = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            mBinderService = ((MyService.MyBinder)service).getInstance();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy()
    {
        unbindService(mServiceConnecion);
        super.onDestroy();
    }
}
