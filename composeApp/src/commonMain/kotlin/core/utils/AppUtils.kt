package core.utils


interface OnLinkClicked {
    fun onClicked(url: String)
    fun onMailClicked(email: String)
}

expect fun getOnLinkClickHandler(): OnLinkClicked


/*
//bg circles
    val offsets = remember {
        mutableListOf<Offset>()
    }
    val colors = remember {
        mutableListOf<Color>()
    }
    LaunchedEffect(true) {
        for (i in 0..10) {
            offsets.add(
                Offset(
                    (i/100f) + Random.nextDouble(0.0, 0.9-(i/100f)).toFloat(),
                    (i/100f) + Random.nextDouble(0.0, 0.9-(i/100f)).toFloat()
                )
            )
            colors.add(
                when (Random.nextInt(0, 3)) {
                    0 -> AppColors.NEON
                    1 -> AppColors.NEON2
                    2 -> AppColors.NEON3
                    else -> AppColors.NEON3
                }
            )
        }
    }
* */