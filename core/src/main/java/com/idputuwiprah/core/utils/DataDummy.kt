package com.idputuwiprah.core.utils

import com.idputuwiprah.core.domain.model.Detail
import com.idputuwiprah.core.domain.model.Movie

object DataDummy {

    fun generateDummyRemoteMovie(): List<Movie> {
        val movies = ArrayList<Movie>()

        var movie = Movie("458576", "Monster Hunter",  "7.2", "2020", "14, 28, 12", "https://image.tmdb.org/t/p/w500/uwjaCH7PiWrkz7oWJ4fcL3xGrb0.jpg", "-")
        movies.add(movie)

        movie = Movie("649087", "Red Dot", "6.2", "2021", "18, 53", "https://image.tmdb.org/t/p/w500/xZ2KER2gOHbuHP2GJoODuXDSZCb.jpg", "-")
        movies.add(movie)

        movie = Movie("581389", "Space Sweepers", "7.3", "2021", "18, 14, 878", "https://image.tmdb.org/t/p/w500/bmemsraCG1kIthY74NjDnnLRT2Q.jpg", "-")
        movies.add(movie)

        movie = Movie("464052", "Wonder Woman 1984", "6.9", "2020", "14, 28, 12", "https://image.tmdb.org/t/p/w500/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",  "-")
        movies.add(movie)

        movie = Movie("602269", "The Little Things", "6.4", "2021", "53, 80", "https://image.tmdb.org/t/p/w500/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg", "-")
        movies.add(movie)

        movie = Movie("599281", "Fear of Rain", "7.4", "2021", "53, 27, 18", "https://image.tmdb.org/t/p/w500/b2shaNA4F8zNIwoRYr33lPTiFfl.jpg", "-")
        movies.add(movie)

        movie = Movie("775996", "Outside the Wire", "6.5", "2021", "53, 28, 878", "https://image.tmdb.org/t/p/w500/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg", "-")
        movies.add(movie)

        movie = Movie("587996", "Below Zero", "6.4", "2021", "28, 80, 53", "https://image.tmdb.org/t/p/w500/dWSnsAGTfc8U27bWsy2RfwZs0Bs.jpg", "-")
        movies.add(movie)

        movie = Movie("522444", "Black Water: Abyss 5", "2020", "27, 53, 12", "https://image.tmdb.org/t/p/w500/95S6PinQIvVe4uJAd82a2iGZ0rA.jpg", "-")
        movies.add(movie)

        movie = Movie("651571", "Breach", "4.5", "2020", "878, 28", "https://image.tmdb.org/t/p/w500/13B6onhL6FzSN2KaNeQeMML05pS.jpg", "-")
        movies.add(movie)

        movie = Movie("604822", "Vanguard", "6.5", "2020", "28, 12, 80", "https://image.tmdb.org/t/p/w500/vYvppZMvXYheYTWVd8Rnn9nsmNp.jpg", "-")
        movies.add(movie)

        movie = Movie("590706", "Jiu Jitsu", "5.3", "2020", "14, 28, 878", "https://image.tmdb.org/t/p/w500/eLT8Cu357VOwBVTitkmlDEg32Fs.jpg", "-")
        movies.add(movie)

        movie = Movie("664767", "Mortal Kombat Legends: Scorpion's Revenge", "8.4", "2020", "14, 28, 12, 16", "https://image.tmdb.org/t/p/w500/4VlXER3FImHeFuUjBShFamhIp9M.jpg", "-")
        movies.add(movie)

        movie = Movie("581387", "Ashfall", "6.6", "2019", "28, 12, 53", "https://image.tmdb.org/t/p/w500/zoeKREZ2IdAUnXISYCS0E6H5BVh.jpg", "-")
        movies.add(movie)

        movie = Movie("560144", "Skylines", "5.7", "2020", "878, 28", "https://image.tmdb.org/t/p/w500/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg", "-")
        movies.add(movie)

        movie = Movie("508442", "Soul", "8.3", "2020", "10751, 16, 35, 18, 10402, 14", "https://image.tmdb.org/t/p/w500/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg", "-")
        movies.add(movie)

        movie = Movie("714277", "The Funeral Home", "0", "2021-04-15", "27, 35", "https://image.tmdb.org/t/p/w500/1rlgIzw129hEl46bFaJZ7wpEEZZ.jpg", "-")
        movies.add(movie)

        movie = Movie("529203", "The Croods: A New Age", "7.6", "2020", "10751, 12, 14, 16", "https://image.tmdb.org/t/p/w500/tK1zy5BsCt1J4OzoDicXmr0UTFH.jpg", "-")
        movies.add(movie)

        movie = Movie("614409", "To All the Boys: Always and Forever", "8", "2021", "35, 18, 10749", "https://image.tmdb.org/t/p/w500/zdkJs9j6yKo9di0kjtctM01fSMv.jpg", "-")
        movies.add(movie)

        movie = Movie("539885", "Ava", "5.6", "2020-07-02", "28, 80, 18, 53", "https://image.tmdb.org/t/p/w500/qzA87Wf4jo1h8JMk9GilyIYvwsA.jpg", "-")
        movies.add(movie)

        return movies
    }

    fun generateDummyRemoteTVShow(): List<Movie> {
        val tvShows = ArrayList<Movie>()

        var tvShow = Movie("85271", "WandaVision", "8.5", "2021-01-15", "[10765, 9648, 18]", "https://image.tmdb.org/t/p/w500/glKDfE6btIRcVB5zrjspRIs4r52.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("69050", "Riverdale", "8.6", "2017-01-26", "[9648, 18, 80]", "https://image.tmdb.org/t/p/w500/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("97513", "The Boarding School: Las Cumbres", "7.4", "2021-02-19", "[18, 9648]", "https://image.tmdb.org/t/p/w500/kl07N07l4XNjXF48oujzWXs40Dw.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("1402", "The Walking Dead", "8", "2010-10-31", "[10759, 18, 10765]", "https://image.tmdb.org/t/p/w500/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("71712", "The Good Doctor", "8.6", "2017-09-25", "[18]", "https://image.tmdb.org/t/p/w500/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("63174", "Lucifer", "8.5", "2016-01-25", "[80, 10765]", "https://image.tmdb.org/t/p/w500/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("1416", "Grey's Anatomy", "8.2", "2005-03-27", "[18]", "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("79460", "Legacies", "8.6", "2018-10-25", "[10765, 18]", "https://image.tmdb.org/t/p/w500/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("77169", "Cobra Kai", "8.1", "2018-05-02", "[10759, 18]", "https://image.tmdb.org/t/p/w500/obLBdhLxheKg8Li1qO11r2SwmYO.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("67133", "MacGyver", "7.1", "2016-09-23", "[18, 10759]", "https://image.tmdb.org/t/p/w500/2zAogx9dmSAu2HYxbWzHe4ZaNY5.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("44217", "Vikings", "8", "2013-03-03", "[10759, 18]", "https://image.tmdb.org/t/p/w500/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("114695", "Marvel Studios: Legends", "7.6", "2021-01-08", "[99]", "https://image.tmdb.org/t/p/w500/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("82856", "The Mandalorian", "8.5", "2019-11-12", "[10765, 10759]", "https://image.tmdb.org/t/p/w500/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("18165", "The Vampire Diaries", "8.3", "2009-09-10", "[18, 10765]", "https://image.tmdb.org/t/p/w500/aBkVgChtyyJaHyZh1gfd8DbzQon.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("1399", "Game of Thrones", "8.4", "2011-04-17", "[10765, 18, 10759]", "https://image.tmdb.org/t/p/w500/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("115857", "Daughter From Another Mother", "7.5", "2021-01-20", "[35, 18]", "https://image.tmdb.org/t/p/w500/6chvnAakKI2cYW69ODBHZHm8clb.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("71728", "Young Sheldon", "8", "2017-09-25", "[35]", "https://image.tmdb.org/t/p/w500/aESxB2HblKlDzma39xVefa20pbW.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("60735", "The Flash", "7.6", "2014-10-07", "[18, 10765]", "https://image.tmdb.org/t/p/w500/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("67335", "Sin senos sí hay paraíso", "7.5", "2016-07-19", "[10759, 80, 18, 9648]", "https://image.tmdb.org/t/p/w500/ulcGG2JKjbVMQFIux1vcQGN1pQi.jpg", "-")
        tvShows.add(tvShow)

        tvShow = Movie("97173", "Behind Her Eyes", "7.9", "2021-02-17", "[18]", "https://image.tmdb.org/t/p/w500/sfd90NIf778KoBFmpdBTow4xTm7.jpg", "-")
        tvShows.add(tvShow)

        return tvShows
    }

    fun generateDummyMovieDetail(): Detail {
        return Detail("587807", "Tom & Jerry", "7.8", "2021", arrayListOf("Action", "Comedy", "Family", "Animation", "Adventure"), "https://image.tmdb.org/t/p/w500/6KErczPBROQty7QoIsaa6wJYXZi.jpg", "1h 41min", "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
        "-", "-", "-", "https://image.tmdb.org/t/p/w500/fev8UFNFFYsD5q7AcYS8LyTzqwl.jpg")
    }

    fun generateDummyTVShowDetail(): Detail {
        return Detail("85271", "WandaVision", "8.5", "2021", arrayListOf("Sci-Fi & Fantasy", "Mystery", "Drama"), "https://image.tmdb.org/t/p/w500/glKDfE6btIRcVB5zrjspRIs4r52.jpg", "36min", "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
            "-", "-", "-")
    }
}