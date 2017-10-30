package com.nh.sample.util

/**
 *
 * <br/><br/>
 * Created by nick.hanna on 10/29/17.
 */
class TextGenerator {

    val SAMUEL_IPSUM = "\n" +
            "You see? It's curious. Ted did figure it out - time travel. And when we get back, we gonna tell everyone. How it's possible, how it's done, what the dangers are. But then why fifty years in the future when the spacecraft encounters a black hole does the computer call it an 'unknown entry event'? Why don't they know? If they don't know, that means we never told anyone. And if we never told anyone it means we never made it back. Hence we die down here. Just as a matter of deductive logic.\n" +
            "\n" +
            "Now that we know who you are, I know who I am. I'm not a mistake! It all makes sense! In a comic, you know how you can tell who the arch-villain's going to be? He's the exact opposite of the hero. And most times they're friends, like you and me! I should've known way back when... You know why, David? Because of the kids. They called me Mr Glass.\n" +
            "\n" +
            "Yeah, I like animals better than people sometimes... Especially dogs. Dogs are the best. Every time you come home, they act like they haven't seen you in a year. And the good thing about dogs... is they got different dogs for different people. Like pit bulls. The dog of dogs. Pit bull can be the right man's best friend... or the wrong man's worst enemy. You going to give me a dog for a pet, give me a pit bull. Give me... Raoul. Right, Omar? Give me Raoul."
    var split: List<String>? = SAMUEL_IPSUM.split(" ")
    var pos: Int = 0


    fun getWords(count: Int) : List<String> {
        if(count + pos > split!!.size) {
            pos = 0
        }

        val ret = split!!.subList(pos, pos+count)
        pos += count
        return ret
    }
}
