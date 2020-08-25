package com.example.customadapters

class Teacher {
    var name:String="siddhant"
        get() = field
    var course:String="android"

    constructor(name: String, course: String) {
        this.name = name
        this.course = course

    }
    companion object{
        fun  getTeacher():ArrayList<Teacher>{

            var teachers:ArrayList<Teacher> = ArrayList<Teacher>()
            teachers.add(Teacher("Arnav","Android"))
            teachers.add(Teacher("Prateek","C++"))
            teachers.add(Teacher("Ayush","Web"))
            teachers.add(Teacher("Hrshit","Webd"))
            teachers.add(Teacher("Siddhatn","time waste"))
            teachers.add(Teacher("rahul","node"))
            return teachers
        }
    }




}