package timeface.eternallyliu.com.testdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

        initFastSort();
    }

    private void initFastSort() {
        //快速排序算法
        a = new int[]{6,1,2,7,9,3,4,5,10,8};
        for (int i = 0; i <=9; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\n---------------------");

        Sort(1,10);

        for (int i = 0; i <=9; i++) {
            System.out.print(a[i] + " ");
            System.out.println("执行啦");
        }
    }

    private void Sort(int left, int right) {
        if (left >= right || left < 1|| right > 10) {
            return;
        }

        int i, j, t, temp;//定义左指针，右指针，交换数，基准数
        temp = a[left -1];//选择最左边的数为基准数
        i = left -1;//初始化左指针
        j = right -1;//初始化右指针

        //首先需要从左向右来执行操作
        while (i != j) {//如果相等的话说明没有符合条件的数，说明基准数就是最小的值，其位置是正确的
            while (a[j] >= temp && i < j) {
                --j;//直到获取到小于temp的a[j]值的时候停止
            }

            while (a[i] <= temp && i < j) {
                ++i;
            }

            if (i < j) {
                t = a[j];
                a[j] = a[i];
                a[i] = t;//交换
            }
        }

        //直到这个时候将i=j的时候那个值与基准数交换，使基准数归位
        a[left-1] = a[i];
        a[i] = temp;
        //到这一次变换就已经完成

        //接下来调用递归分别处理左边和右边
        Sort(left, i);
        Sort(i+2, right);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction("sender");
        intent.putExtra("tag", "这是广播发来的标记");
        sendBroadcast(intent);
    }
}
