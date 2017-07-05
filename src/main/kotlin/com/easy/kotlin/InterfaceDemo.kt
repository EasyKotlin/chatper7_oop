package com.easy.kotlin

/**
 * Created by jack on 2017/7/2.
 */

class Project

class Milestone

interface ProjectService {
    val name: String
    val owner: String
    fun save(project: Project)
    fun print() {
        println("I am project")
    }
}

interface MilestoneService {
    val name: String // 抽象的
    val owner: String get() = "Jack" // 访问器

    fun save(milestone: Milestone)
    fun print() {
        println("I am Milestone")
    }
}


class MilestoneServiceImpl : MilestoneService {
    override val name: String
        get() = "MilestoneServiceImpl name"


    override fun save(milestone: Milestone) {
        println("save Milestone")
    }
}

class ProjectServiceImpl1 : ProjectService {

    override val name: String
        get() = "X Project"
    override val owner: String
        get() = "Jack"

    override fun save(project: Project) {
    }
}

class ProjectServiceImpl2(override val name: String, override val owner: String) : ProjectService {
    override fun save(project: Project) {
    }
}


abstract class ProjectServiceImpl3 : ProjectService {
}


class ProjectMilestoneServiceImpl : ProjectService, MilestoneService {
    override val name: String
        get() = "ProjectMilestone"
    override val owner: String
        get() = "Jack"

    override fun save(project: Project) {
        println("Save Project")
    }

    override fun print() {
//        super.print()
        super<ProjectService>.print()
        super<MilestoneService>.print()
    }

    override fun save(milestone: Milestone) {
        println("Save Milestone")
    }
}

fun main(args: Array<String>) {
//    val p = ProjectService() // interface does not have constructors
    val p1 = ProjectServiceImpl1()
    val p2 = ProjectServiceImpl2("X Project", "Jack")
    //val p3 = ProjectServiceImpl3() // cannot create an instance of abstract class

}
