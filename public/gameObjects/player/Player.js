'use strict'
class Player extends GameObject {
    constructor(x, y) {
        super(x, y)
        this.objId = 'PLAYER'
    }

    tick(delta) {
        this.x += this.velX * delta
        this.y += this.velY * delta
    }

    render(ctx) {
        ctx.fillRect(this.x, this.y, 10, 10)
    }
}
