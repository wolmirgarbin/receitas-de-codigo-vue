// CommitChart.js
import { HorizontalBar } from 'vue-chartjs'

export default HorizontalBar.extend({
    mounted () {
        // Overwriting base render method with actual data.
        this.renderChart({
            labels: ['Média', 'Plano', 'Uso do Mês'],
            datasets: [
                {
                    label: 'Plano x Média x Uso do Mês',
                    backgroundColor: '#1565c0',
                    data: [2400, 3000, 400]
                }
            ]
        })
    }
})