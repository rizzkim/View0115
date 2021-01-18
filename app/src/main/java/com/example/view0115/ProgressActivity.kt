package com.example.view0115

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_progress.*
import java.util.*

class ProgressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        //버튼 2개의 클릭 이벤트 처리
        btnStart.setOnClickListener({
            progressbar.incrementProgressBy(10)
            //원 모양으로 프로그래스 바 애니메이션 시작
            progressind.setVisibility(View.VISIBLE)
        })

        btnStop.setOnClickListener({
            progressbar.incrementProgressBy(-10)
            //원 모양으로 프로그래스 바 애니메이션 중지
            progressind.setVisibility(View.INVISIBLE)
        })


        //seekbar 값이 변경될 때 이벤트 처리
        //Seekbar.OnSeekBarChangeListener: 메소드가 3개 이므로
        //람다를 바로 대입하는 것은 안됩니다.
        seekbar.setOnSeekBarChangeListener(
            object: SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    volume.setText("Volume:${progress}")
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    Toast.makeText(this@ProgressActivity,
                        "트래킹 시작", Toast.LENGTH_LONG).show()
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    Toast.makeText(this@ProgressActivity,
                        "트래킹 종료", Toast.LENGTH_LONG).show()
                }
            }
        )

        //ratingbar의 값이 변경될 때 그 값을 텍스트 뷰에 출력
        //값이 변경되는 것을 RadingBar.OnRatingBarChangeListener가 처리
        ratingbar.setOnRatingBarChangeListener{
            ratingbar, rating, fromUser ->
            avg.text = "평점:${rating}"
        }

    }
}