package com.example.minder.utils

import com.example.minder.model.Note
import com.example.minder.model.Task
import com.example.minder.model.Tracker
import com.example.minder.presentation.utils.Category
import com.example.minder.presentation.utils.Day

object Constants {
    val noteMocked = Note(
        title = "The Noodle Kingdom's Silly Rhyme",
        content = "In a land of noodles, where pineapples dance,\n" +
                "A squirrel wore sunglasses, giving a chance.\n" +
                "To the moon, he declared, \"I'm the king of the night!\"\n" +
                "But it was daytime, and the moon was out of sight.\n" +
                "\n" +
                "The clouds giggled softly, the trees started to hum,\n" +
                "As a pancake flew by, playing a drum.\n" +
                "In this world of wacky, where nonsense is prime,\n" +
                "The stupider the poem, the better the rhyme.",
        creationDate = "12.06.2023",
        color = 0xFFFBF6AA
    )

    val taskMocked = Task(
        title = "goldfish breakdance",
        content = "Teach a goldfish how to breakdance and record its underwater moves for a potential viral sensation. Bonus points if the fish wears a tiny top hat during its performance",
        done = false,
        creationDate = "12.06.2003",
        deadlineDate = null,
        color = 0xFFFBF6AA
    )

    val trackerMocked = Tracker(
        title = "Daily daydreaming",
        description = "Monitor the number of times I catch yourself daydreaming about becoming a professional pogo stick rider while waiting for the elevator. Record your enthusiasm level on a scale from 'hopping mad' to 'bouncing bliss",
        days = 30,
        creationDate = "12.06.2023",
        startDay = "12.06.2023",
        finishDate = "11.07.2023",
        doneNum = 10,
        color = 0xFFFBF6AA
    )


    val noteListMocked = listOf(
        noteMocked.copy(color = 0xFFFFD8F4),
        noteMocked,
        noteMocked.copy(color = 0xFFFFDBE3),
        noteMocked.copy(color = 0xFF73F8B0))
    val taskListMocked = listOf(
        taskMocked,
        taskMocked.copy(color = 0xFF73F8B0),
        taskMocked.copy(color = 0xFFC2DCFD),
        taskMocked.copy(color = 0xFFFCFAD9),
        taskMocked.copy(color = 0xFFFFDBE3),
        taskMocked,
        taskMocked)
    val trackerListMocked = listOf(
        trackerMocked.copy(color = 0xFF73F8B0),
        trackerMocked.copy(doneNum = 5, color = 0xFFFFD8F4),
        trackerMocked.copy(doneNum = 23, color = 0xFFFFDBE3),
        trackerMocked.copy(doneNum = 1),
        trackerMocked.copy(doneNum = 30, color = 0xFFC2DCFD)
    )

    val dayMocked = Day(11, "Mon", false, false)
    val dayListMocked = listOf(
        dayMocked,
        dayMocked,
        dayMocked.copy(isChosen = true, isToday = true),
        dayMocked,
        dayMocked,
        dayMocked,
        dayMocked
    )

    val categoryMocked = Category("Work", 0xFFC2DCFD)
    val categoryListMocked = listOf(
        Category("Work", 0xFFC2DCFD),
        Category("Study", 0xFFD9E8FC),
        Category("Poems", 0xFFFFD8F4),
        Category("Thoughts", 0xFFF1DBF5),
        Category("English", 0xFFFFDBE3),
        Category("Math", 0xFFFBF6AA),
        Category("Android", 0xFFFCFAD9)
    )

}