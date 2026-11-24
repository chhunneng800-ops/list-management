package com.example.reviewlistandadapter1
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.IntentCompat


class SearchStudentActivity: ComponentActivity() {
    lateinit var listViewStudent: ListView
    lateinit var searchView : SearchView
    lateinit var adapterStudent: ArrayAdapter<Student>
    lateinit var searchList: ArrayList<Student>
    lateinit var studentList: ArrayList<Student>





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_student)

        listViewStudent = findViewById(R.id.listViewStudent)
        searchView = findViewById(R.id.searchView)

        showStudentList()


//        searchlistAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searchList)
//        listViewStudent.adapter = searchlistAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                if (searchList.contains(query)) {
//                    adapterStudent.filter.filter(query)
//                } else {
//                    Toast.makeText(this@SearchStudentActivity, "No Match found", Toast.LENGTH_LONG).show()
//                }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                for (i in studentList) {
                    if (i.name.contains(newText.toString(), ignoreCase = true)) {
                        searchList.add(i)
                    }
                }
                val newList = StudentAdapterViewAdapter(this@SearchStudentActivity, searchList)
                listViewStudent.adapter = newList

                return true
            }
        })
        listViewStudent.setOnItemLongClickListener { parent, view, position, id ->
            val student = parent.getItemAtPosition(position) as Student
//            Toast.makeText(this, "Long clicked: $student", Toast.LENGTH_SHORT).show()
            AlertDialog.Builder(this)
                .setTitle("Confirm Action")
                .setMessage("Are you sure you want Delete this student?")
                .setPositiveButton(android.R.string.ok) { dialog, _ ->
                    // create new arry to store becasue cannot delete arry it wrong index
                    val newList = ArrayList<Student>()
                    for (i in studentList) {
                        if(i.id != student.id) {
                            newList.add(i)
                        }
                    }
                    // update list to show the view in screen
                    studentList = newList

                    adapterStudent = StudentAdapterViewAdapter(this, studentList)
                    listViewStudent.adapter = adapterStudent


                    Toast.makeText(this, "OK clicked", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(android.R.string.cancel) { dialog, _ ->
                    // Handle Cancel click
                    dialog.dismiss()
                }
                .show()
            // Return true to indicate the event was handled and prevent a regular click from firing
            true
        }

    }
    fun showStudentList() {
        studentList = arrayListOf<Student>()
        studentList.add(Student(1, R.drawable.pic1, "A", "Dara", 20, "Female", 38.5))
        studentList.add(Student(2, R.drawable.pic2, "B", "bopa", 23, "Male", 18.5))
        studentList.add(Student(3, R.drawable.pic3, "C", "uini", 22, "Female", 58.5))
        studentList.add(Student(4, R.drawable.pic4, "D", "erer", 19, "Male", 68.5))
        studentList.add(Student(5, R.drawable.pic5, "E", "gege", 18, "Female", 98.5))

        searchList = arrayListOf<Student>()

        adapterStudent = StudentAdapterViewAdapter(this, studentList)
        listViewStudent.adapter = adapterStudent


        val l : ListView
        l = findViewById<ListView>(R.id.listViewStudent)

        if (studentList != null) {
            var arradapter: StudentAdapterViewAdapter =
                StudentAdapterViewAdapter(this, studentList)
            l.adapter = arradapter
        }


        l.setOnItemClickListener { parent, view, index, id ->
            val selectedItem = parent.getItemAtPosition(index) as Student

            val intent = Intent(this, StudentDetailActivity::class.java)
            intent.putExtra("User", Student(id = selectedItem.id, image = selectedItem.image, stdClass = selectedItem.stdClass, name = selectedItem.name, age = selectedItem.age, gender = selectedItem.gender, score = selectedItem.score))
            this.startActivity(intent)


        }


    }

}
