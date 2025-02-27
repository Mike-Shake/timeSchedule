package Utils;

import static android.content.Context.MODE_PRIVATE;
import static Utils.changeTextStyle.change;
import static Utils.changeTextStyle.change_2;
import static Utils.changeTime.changeHour;
import static Utils.changeTime.changeMinute;
import static Utils.music.music_0;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class openMusic {
    public static void openmusic(TextView mTextView_3, View view, Activity activity) {

                if (activity == null) {
                    return;
                } else {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Timer timer = new Timer();
                            boolean a = false;
                            timer.schedule(new TimerTask() {
                                int flag = 0;
                                @Override
                                public void run() {
                                    SharedPreferences sharedPreferences = activity.getSharedPreferences("bmi", MODE_PRIVATE);
                                    int hour_0 = sharedPreferences.getInt("hour123", 0);
                                    Log.d("TAG111","DU"+hour_0);
                                    int minute = sharedPreferences.getInt("minute123", 0);
                                    activity.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            mTextView_3.setText((changeHour((hour_0)) + ":" + changeMinute((minute))));
                                            change(mTextView_3, activity);
                                        }
                                    });
                                    Calendar calendar = Calendar.getInstance();
                                    int hour_1 = calendar.get(Calendar.HOUR_OF_DAY);
                                    int minute_1 = calendar.get(Calendar.MINUTE);
                                    if (hour_0 == hour_1 && minute_1 == minute) {
                                        music_0(view, activity);
                                        flag = 1;
                                    }
                                    if (flag == 1) {
                                        timer.cancel();
                                    }
                                }
                            }, 0, 100);
                        }
                    });
                }

    }
}
