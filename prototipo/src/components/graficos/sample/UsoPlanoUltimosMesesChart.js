// CommitChart.js
import { Line } from 'vue-chartjs'

export default Line.extend({
    mounted () {
        // Overwriting base render method with actual data.
        this.renderChart({
            labels: ['July', 'August', 'September', 'October', 'November', 'December'],
            datasets: [
                {
                    label: 'Documentos',
                    backgroundColor: '#1565c0',
                    data: [5000, 1100, 2020, 1300, 920, 400]
                },
                {
                    label: 'Plano Contratado',
                    backgroundColor: '#000',
                    data: [3000, 3000, 3000, 3000, 3000, 3000]
                }
            ]
        })
    }
})