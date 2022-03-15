import java.awt.Component
import java.awt.EventQueue
import java.awt.event.ActionEvent
import javax.swing.*
import kotlin.random.Random

class SupportMachine(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        // List of messages that is randomly picked for encouragement
        val messages = listOf(
            "Encouragement!",
            "The :INSERT LEAST FAVORITE SPORTS TEAM HERE: didn't win!",
            "It's almost Friday!",
            "At least it can't get any worse!",
            "Congrats on doing that one thing!",
            "Your birthday is no more than than a year away!",
            "This code ran without bugs!",
            "You're almost done with your daily socialization!",
            "You're in class with :INSERT PROFESSOR NAME HERE: !",
            "Your investment in crypto hasn't crashed!"
        )

        val closeBtn = JButton("Give me support")

        // On click, button will make a new dialog box appear with a random message
        closeBtn.addActionListener {e: ActionEvent ->
            JOptionPane.showMessageDialog(
                e.source as Component,
                messages[Random.nextInt(0,10)]
            )
        }

        createLayout(closeBtn)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(180, 80)
        setLocationRelativeTo(null)
    }


    // Places button into containers and creates gaps between window borders and button
    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true

        gl.setHorizontalGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
        )

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
        )

        pack()
    }
}



private fun createAndShowGUI() {

    val frame = SupportMachine("Words of Encouragement")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
