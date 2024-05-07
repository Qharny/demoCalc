import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.scene.layout.AnchorPane
import java.util.*

class HelloController {

    @FXML
    private lateinit var MyController: AnchorPane

    @FXML
    private lateinit var bracketClose: Button

    @FXML
    private lateinit var bracketOpen: Button

    @FXML
    private lateinit var clear: Button

    @FXML
    private lateinit var dZero: Button

    @FXML
    private lateinit var delete: Button

    @FXML
    private lateinit var divide: Button

    @FXML
    private lateinit var dot: Button

    @FXML
    private lateinit var eight: Button

    @FXML
    private lateinit var equals: Button

    @FXML
    private lateinit var five: Button

    @FXML
    private lateinit var four: Button

    @FXML
    private lateinit var minus: Button

    @FXML
    private lateinit var mode: Button

    @FXML
    private lateinit var negate: Button

    @FXML
    private lateinit var nine: Button

    @FXML
    private lateinit var one: Button

    @FXML
    private lateinit var percent: Button

    @FXML
    private lateinit var plus: Button

    @FXML
    private lateinit var seven: Button

    @FXML
    private lateinit var six: Button

    @FXML
    private lateinit var square: Button

    @FXML
    private lateinit var three: Button

    @FXML
    private lateinit var times: Button

    @FXML
    private lateinit var two: Button

    @FXML
    private lateinit var txtArea: TextArea

    @FXML
    private lateinit var zero: Button

    @FXML
    fun onClick(event: ActionEvent) {
        val source = event.source as Button
        val buttonText = source.text
        var currentText = txtArea.text

        when (buttonText) {
            "C" -> {
                // Clear the text area
                currentText = ""
            }
            "⌫" -> {
                // Remove the last character if the text is not empty
                if (currentText.isNotEmpty()) {
                    currentText = currentText.dropLast(1)
                }
            }
            "=" -> {
                // Evaluate the expression in the text area
                try {
                    val result = evaluateExpression(currentText)
                    currentText = result.toString()
                } catch (e: Exception) {
                    // Handle invalid expressions
                    currentText = "Error"
                }
            }
            ".", "+", "-", "*", "/" -> {
                // Append the operator to the text area if it's a valid position
                if (currentText.isNotEmpty() && currentText.last() !in arrayOf('.', '+', '-', '*', '/')) {
                    currentText += buttonText
                }
            }
            else -> {
                // Append the text of the clicked button to the text area
                currentText += buttonText
            }
        }

        // Update the text area with the new text
        txtArea.text = currentText
    }

    private fun evaluateExpression(expression: String): Double {
        val tokens = expression.split("\\s+".toRegex())
        val stack = Stack<Double>()

        for (token in tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?".toRegex())) {
                stack.push(token.toDouble())
            } else {
                val operand2 = stack.pop()
                val operand1 = stack.pop()
                val result = when (token) {
                    "+" -> operand1 + operand2
                    "-" -> operand1 - operand2
                    "*" -> operand1 * operand2
                    "/" -> operand1 / operand2
                    else -> throw IllegalArgumentException("Invalid operator: $token")
                }
                stack.push(result)
            }
        }

        return stack.pop()
    }

}
