package com.udacity.asteroidradar

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.udacity.asteroidradar.domain.PictureOfDay

@BindingAdapter("statusIcon")
fun bindAsteroidStatusIcon(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
        imageView.contentDescription =
            imageView.context.getString(R.string.potentially_hazardous_asteroid_icon)
    } else {
        imageView.setImageResource(R.drawable.ic_status_normal)
        imageView.contentDescription =
            imageView.context.getString(R.string.not_hazardous_asteroid_icon)
    }
}

@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
        imageView.contentDescription = imageView.context.getString(R.string.potentially_hazardous_asteroid_image)

    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
        imageView.contentDescription = imageView.context.getString(R.string.not_hazardous_asteroid_image)
    }
}

@BindingAdapter("astronomicalUnitText")
fun bindTextViewToAstronomicalUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("kmUnitText")
fun bindTextViewToKmUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_unit_format), number)
}

@BindingAdapter("velocityText")
fun bindTextViewToDisplayVelocity(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_s_unit_format), number)
}

@BindingAdapter("imageOfTheDay")
fun bindImageOfTheDay(imageView: ImageView, pictureOfDay: PictureOfDay?) {
    if (pictureOfDay?.mediaType == "image") {
        imageView.contentDescription = imageView.context.getString(R.string.image_of_the_day) + ": " + pictureOfDay.title
        Picasso.get()
            .load(pictureOfDay.url)
            .into(imageView)
    } else {
        imageView.contentDescription = imageView.context.getString(R.string.no_image)
        imageView.setImageResource(R.drawable.placeholder_picture_of_day)
    }
}