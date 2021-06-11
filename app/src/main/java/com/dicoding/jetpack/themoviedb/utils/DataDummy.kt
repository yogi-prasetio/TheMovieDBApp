package com.dicoding.jetpack.themoviedb.utils

import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity
import com.dicoding.jetpack.themoviedb.data.source.remote.response.MoviesResponse
import com.dicoding.jetpack.themoviedb.data.source.remote.response.TvShowResponse
import java.util.ArrayList

object DataDummy {
    fun generateDummyMovies(): List<MoviesEntity> {

        val movies = ArrayList<MoviesEntity>()

        movies.add(MoviesEntity(460465,
            460465,
            "https://image.tmdb.org/t/p/original/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            "Mortal Kombat",
            "2021/04/14",
//            110,
            "7.7",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe."))
        movies.add(MoviesEntity(
            399566,
            399566,
            "https://image.tmdb.org/t/p/original/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "Godzilla vs. Kong",
            "2021-03-24",
//            113,
            "8.1",
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages."))
        movies.add(MoviesEntity(
            615457,
            615457,
            "https://image.tmdb.org/t/p/original/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
            "Nobody",
            "2021-03-26",
//            92,
            "8.5",
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind."))
        movies.add(MoviesEntity(
            567189,
            567189,
            "https://image.tmdb.org/t/p/original/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            "Tom Clancy's Without Remorse",
            "2021-04-29",
//            109,
            "7.3",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife."))
        movies.add(MoviesEntity(
            804435,
            804435,
            "https://image.tmdb.org/t/p/original/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
            "Vanquish",
            "2021-04-16",
//            96,
            "6.4",
            "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again."))
        movies.add(MoviesEntity(
            791373,
            791373,
            "https://image.tmdb.org/t/p/original/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
            "Zack Snyder's Justice League",
            "2021-03-18",
//            242,
            "8.5",
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions."))
        movies.add(MoviesEntity(
            632357,
            632357,
            "https://image.tmdb.org/t/p/original/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
            "The Unholy",
            "2021-03-31",
//            99,
            "5.6",
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister."))
        movies.add(MoviesEntity(
            635302,
            635302,
            "https://image.tmdb.org/t/p/original/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
            "劇場版「鬼滅の刃」無限列車編",
            "2020-10-16",
//            117,
            "8.4",
            "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!"))
        movies.add(MoviesEntity(
            634528,
            634528,
            "https://image.tmdb.org/t/p/original/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
            "The Marksman",
            "2021-01-15",
//            108,
            "7.4",
            "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins."))
        movies.add(MoviesEntity(
            726684,
            726684,
            "https://image.tmdb.org/t/p/original/jaQiXB7ZCiW8zUCnuZ7sf73yX4Z.jpg",
            "Miraculous World",
            "2021-04-04",
//            52,
            "7.8",
            "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time..."))
        return movies
    }

    fun generateDummyTvshow(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(TvShowEntity(
            88396,
            88396,
            "https://image.tmdb.org/t/p/original/kbAMLteGO8yyewYau6bJ683sw7.jpg",
            "The Falcon and the Winter Soldier",
            "2021-03-19",
            "7.9",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience."))
        tvShow.add(TvShowEntity(
            95557,
            95557,
            "https://image.tmdb.org/t/p/original/4UEfVAuI4Yn09nzJ16NFR1pv3ac.jpg",
            "Invincible",
            "2021-03-26",
            "8.9",
            "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage."))
        tvShow.add(TvShowEntity(
            60735,
            60735,
            "https://image.tmdb.org/t/p/original/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "The Flash",
            "2014-10-07",
            "7.7",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."))
        tvShow.add(TvShowEntity(
            71712,
            71712,
            "https://image.tmdb.org/t/p/original/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg",
            "The Good Doctor",
            "2017-09-25",
            "8.6",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives"))
        tvShow.add(TvShowEntity(
            1416,
            1416,
            "https://image.tmdb.org/t/p/original/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
            "Grey's Anatomy",
            "2005-03-27",
            "8.2",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital."))
        tvShow.add(TvShowEntity(
            97180,
            97180,
            "https://image.tmdb.org/t/p/original/mYsWyfiIMxx4HDm0Wck7oJ9ckez.jpg",
            "Selena: The Series",
            "2020-12-04",
            "7.5",
            "As Mexican-American Tejano singer Selena comes of age and realizes her dreams, she and her family make tough choices to hold on to love and music."))
        tvShow.add(TvShowEntity(
            79008,
            79008,
            "https://image.tmdb.org/t/p/original/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
            "Luis Miguel: The Series",
            "2018-04-22",
            "8.0",
            "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades."))
        tvShow.add(TvShowEntity(
            69478,
            69478,
            "https://image.tmdb.org/t/p/original/Q6Kgm3SgFC5krNiwP4N8tUPtSP.jpg",
            "The Handmaid's Tale",
            "2017-04-26",
            "8.2",
            "Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship. A TV adaptation of Margaret Atwood's novel."))
        tvShow.add(TvShowEntity(
            63174,
            63174,
            "https://image.tmdb.org/t/p/original/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            "Lucifer",
            "2016-01-25",
            "8.5",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape."))
        tvShow.add(TvShowEntity(
            69050,
            69050,
            "https://image.tmdb.org/t/p/original/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
            "Riverdale",
            "2017-01-26",
            "8.6",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade."))
        return tvShow
    }

    fun generateRemoteDummyMovies(): List<MoviesResponse> {

        val movies = ArrayList<MoviesResponse>()

        movies.add(MoviesResponse(460465,
            "https://image.tmdb.org/t/p/original/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            "Mortal Kombat",
            "2021/04/14",
//            110,
            "7.7",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe."))
        movies.add(MoviesResponse(399566,
            "https://image.tmdb.org/t/p/original/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "Godzilla vs. Kong",
            "2021-03-24",
//            113,
            "8.1",
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages."))
        movies.add(MoviesResponse(615457,
            "https://image.tmdb.org/t/p/original/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
            "Nobody",
            "2021-03-26",
//            92,
            "8.5",
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind."))
        movies.add(MoviesResponse(567189,
            "https://image.tmdb.org/t/p/original/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            "Tom Clancy's Without Remorse",
            "2021-04-29",
//            109,
            "7.3",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife."))
        movies.add(MoviesResponse(804435,
            "https://image.tmdb.org/t/p/original/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
            "Vanquish",
            "2021-04-16",
//            96,
            "6.4",
            "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again."))
        movies.add(MoviesResponse(791373,
            "https://image.tmdb.org/t/p/original/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
            "Zack Snyder's Justice League",
            "2021-03-18",
//            242,
            "8.5",
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions."))
        movies.add(MoviesResponse(632357,
            "https://image.tmdb.org/t/p/original/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
            "The Unholy",
            "2021-03-31",
//            99,
            "5.6",
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister."))
        movies.add(MoviesResponse(635302,
            "https://image.tmdb.org/t/p/original/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
            "劇場版「鬼滅の刃」無限列車編",
            "2020-10-16",
//            117,
            "8.4",
            "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!"))
        movies.add(MoviesResponse(634528,
            "https://image.tmdb.org/t/p/original/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
            "The Marksman",
            "2021-01-15",
//            108,
            "7.4",
            "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins."))
        movies.add(MoviesResponse(726684,
            "https://image.tmdb.org/t/p/original/jaQiXB7ZCiW8zUCnuZ7sf73yX4Z.jpg",
            "Miraculous World",
            "2021-04-04",
//            52,
            "7.8",
            "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time..."))
        return movies
    }

    fun generateRemoteDummyTvshow(): List<TvShowResponse> {

        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(TvShowResponse(
            88396,
            "https://image.tmdb.org/t/p/original/kbAMLteGO8yyewYau6bJ683sw7.jpg",
            "The Falcon and the Winter Soldier",
            "2021-03-19",
            "7.9",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience."))
        tvShow.add(TvShowResponse(
            95557,
            "https://image.tmdb.org/t/p/original/4UEfVAuI4Yn09nzJ16NFR1pv3ac.jpg",
            "Invincible",
            "2021-03-26",
            "8.9",
            "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage."))
        tvShow.add(TvShowResponse(
            60735,
            "https://image.tmdb.org/t/p/original/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "The Flash",
            "2014-10-07",
            "7.7",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."))
        tvShow.add(TvShowResponse(
            71712,
            "https://image.tmdb.org/t/p/original/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg",
            "The Good Doctor",
            "2017-09-25",
            "8.6",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives"))
        tvShow.add(TvShowResponse(
            1416,
            "https://image.tmdb.org/t/p/original/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
            "Grey's Anatomy",
            "2005-03-27",
            "8.2",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital."))
        tvShow.add(TvShowResponse(
            97180,
            "https://image.tmdb.org/t/p/original/mYsWyfiIMxx4HDm0Wck7oJ9ckez.jpg",
            "Selena: The Series",
            "2020-12-04",
            "7.5",
            "As Mexican-American Tejano singer Selena comes of age and realizes her dreams, she and her family make tough choices to hold on to love and music."))
        tvShow.add(TvShowResponse(
            79008,
            "https://image.tmdb.org/t/p/original/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
            "Luis Miguel: The Series",
            "2018-04-22",
            "8.0",
            "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades."))
        tvShow.add(TvShowResponse(
            69478,
            "https://image.tmdb.org/t/p/original/Q6Kgm3SgFC5krNiwP4N8tUPtSP.jpg",
            "The Handmaid's Tale",
            "2017-04-26",
            "8.2",
            "Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship. A TV adaptation of Margaret Atwood's novel."))
        tvShow.add(TvShowResponse(
            63174,
            "https://image.tmdb.org/t/p/original/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            "Lucifer",
            "2016-01-25",
            "8.5",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape."))
        tvShow.add(TvShowResponse(
            69050,
            "https://image.tmdb.org/t/p/original/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
            "Riverdale",
            "2017-01-26",
            "8.6",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade."))
        return tvShow
    }
}